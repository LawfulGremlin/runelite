/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.mining;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Instant;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;

class MiningOverlay extends Overlay
{
	// Range of Motherlode vein respawn time not 100% confirmed but based on observation
	@Getter(AccessLevel.PACKAGE)
	private static final int ORE_VEIN_MAX_RESPAWN_TIME = 123;
	private static final int ORE_VEIN_MIN_RESPAWN_TIME = 90;
	private static final float ORE_VEIN_RANDOM_PERCENT_THRESHOLD = (float) ORE_VEIN_MIN_RESPAWN_TIME / ORE_VEIN_MAX_RESPAWN_TIME;
	private static final Color DARK_GREEN = new Color(0, 100, 0);

	private final Client client;
	private final MiningPlugin plugin;

	@Inject
	private MiningOverlay(Client client, MiningPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		List<RockRespawn> respawns = plugin.getRespawns();
		if (respawns.isEmpty())
		{
			return null;
		}

		Instant now = Instant.now();
		for (Iterator<RockRespawn> it = respawns.iterator(); it.hasNext();)
		{
			Color pieFillColor = Color.YELLOW;
			Color pieBorderColor = Color.ORANGE;
			RockRespawn rockRespawn = it.next();
			float percent = (now.toEpochMilli() - rockRespawn.getStartTime().toEpochMilli()) / (float) rockRespawn.getRespawnTime();
			WorldPoint worldPoint = rockRespawn.getWorldPoint();
			LocalPoint loc = LocalPoint.fromWorld(client, worldPoint);
			if (loc == null || percent > 1.0f)
			{
				it.remove();
				continue;
			}

			Point point = Perspective.localToCanvas(client, loc, client.getPlane(), rockRespawn.getZOffset());
			if (point == null)
			{
				it.remove();
				continue;
			}

			// Recolour pie on motherlode veins during the portion of the timer where they may respawn
			if (rockRespawn.getRock() == Rock.ORE_VEIN && percent > ORE_VEIN_RANDOM_PERCENT_THRESHOLD)
			{
				pieFillColor = Color.GREEN;
				pieBorderColor = DARK_GREEN;
			}

			ProgressPieComponent ppc = new ProgressPieComponent();
			ppc.setBorderColor(pieBorderColor);
			ppc.setFill(pieFillColor);
			ppc.setPosition(point);
			ppc.setProgress(percent);
			ppc.render(graphics);
		}
		return null;
	}
}
