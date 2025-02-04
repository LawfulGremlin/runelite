/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Modified by farhan1666
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
package net.runelite.client.plugins.aoewarnings;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Stub;

@ConfigGroup("aoe")
public interface AoeWarningConfig extends Config
{
	@ConfigItem(
		keyName = "aoeNotifyAll",
		name = "Notify for all AoE warnings",
		description = "Configures whether or not AoE Projectile Warnings should trigger a notification",
		position = 0
	)
	default boolean aoeNotifyAll()
	{
		return false;
	}

	@ConfigItem(
		keyName = "overlayStub",
		name = "Overlay",
		description = "",
		position = 1
	)
	default Stub overlayStub()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 2,
		keyName = "overlayColor",
		name = "Overlay Color",
		description = "Configures the color of the AoE Projectile Warnings overlay",
		parent = "overlayStub"
	)
	default Color overlayColor()
	{
		return new Color(0, 150, 200);
	}

	@ConfigItem(
		keyName = "outline",
		name = "Display Outline",
		description = "Configures whether or not AoE Projectile Warnings have an outline",
		parent = "overlayStub",
		position = 3
	)
	default boolean isOutlineEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "delay",
		name = "Fade Delay",
		description = "Configures the amount of time in milliseconds that the warning lingers for after the projectile has touched the ground",
		parent = "overlayStub",
		position = 4
	)
	default int delay()
	{
		return 300;
	}

	@ConfigItem(
		keyName = "fade",
		name = "Fade Warnings",
		description = "Configures whether or not AoE Projectile Warnings fade over time",
		parent = "overlayStub",
		position = 5
	)
	default boolean isFadeEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "npcStub",
		name = "NPC's",
		description = "",
		position = 6
	)
	default Stub npcStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "lizardmanaoeStub",
		name = "Lizardman Shamans",
		description = "",
		position = 7,
		parent = "npcStub"
	)
	default Stub lizardmanaoeStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "lizardmanaoe",
		name = "Lizardman Shamans",
		description = "Configures whether or not AoE Projectile Warnings for Lizardman Shamans is displayed",
		parent = "lizardmanaoeStub",
		position = 8
	)
	default boolean isShamansEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "lizardmanaoenotify",
		name = "Lizardman Shamans Notify",
		description = "Configures whether or not AoE Projectile Warnings for Lizardman Shamans should trigger a notification",
		parent = "lizardmanaoeStub",
		position = 9,
		hide = "aoeNotifyAll"
	)
	default boolean isShamansNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "archaeologistaoeStub",
		name = "Crazy Archaeologist",
		description = "",
		position = 10,
		parent = "npcStub"
	)
	default Stub archaeologistaoeStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "archaeologistaoe",
		name = "Crazy Archaeologist",
		description = "Configures whether or not AoE Projectile Warnings for Archaeologist is displayed",
		parent = "archaeologistaoeStub",
		position = 11
	)
	default boolean isArchaeologistEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "archaeologistaoenotify",
		name = "Crazy Archaeologist Notify",
		description = "Configures whether or not AoE Projectile Warnings for Crazy Archaeologist should trigger a notification",
		parent = "archaeologistaoeStub",
		position = 12,
		hide = "aoeNotifyAll"
	)
	default boolean isArchaeologistNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "icedemonStub",
		name = "Ice Demon",
		description = "",
		position = 13,
		parent = "npcStub"
	)
	default Stub icedemonStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "icedemon",
		name = "Ice Demon",
		description = "Configures whether or not AoE Projectile Warnings for Ice Demon is displayed",
		parent = "icedemonStub",
		position = 14
	)
	default boolean isIceDemonEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "icedemonnotify",
		name = "Ice Demon Notify",
		description = "Configures whether or not AoE Projectile Warnings for Ice Demon should trigger a notification",
		parent = "icedemonStub",
		position = 15,
		hide = "aoeNotifyAll"
	)
	default boolean isIceDemonNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "vasaStub",
		name = "Vasa",
		description = "",
		position = 16,
		parent = "npcStub"
	)
	default Stub vasaStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "vasa",
		name = "Vasa",
		description = "Configures whether or not AoE Projectile Warnings for Vasa is displayed",
		parent = "vasaStub",
		position = 17
	)
	default boolean isVasaEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "vasanotify",
		name = "Vasa Notify",
		description = "Configures whether or not AoE Projectile Warnings for Vasa should trigger a notification",
		parent = "vasaStub",
		position = 18,
		hide = "aoeNotifyAll"
	)
	default boolean isVasaNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "tektonStub",
		name = "Tekton",
		description = "",
		position = 19,
		parent = "npcStub"
	)
	default Stub tektonStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "tekton",
		name = "Tekton",
		description = "Configures whether or not AoE Projectile Warnings for Tekton is displayed",
		parent = "tektonStub",
		position = 20
	)
	default boolean isTektonEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "tektonnotify",
		name = "Tekton Notify",
		description = "Configures whether or not AoE Projectile Warnings for Tekton should trigger a notification",
		parent = "tektonStub",
		position = 21,
		hide = "aoeNotifyAll"
	)
	default boolean isTektonNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "vorkathStub",
		name = "Vorkath",
		description = "",
		position = 22,
		parent = "npcStub"
	)
	default Stub vorkathStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "vorkath",
		name = "Vorkath",
		description = "Configures whether or not AoE Projectile Warnings for Vorkath are displayed",
		parent = "vorkathStub",
		position = 23
	)
	default boolean isVorkathEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "vorkathotify",
		name = "Vorkath Notify",
		description = "Configures whether or not AoE Projectile Warnings for Vorkath should trigger a notification",
		parent = "vorkathStub",
		position = 24,
		hide = "aoeNotifyAll"
	)
	default boolean isVorkathNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "galvekStub",
		name = "Galvek",
		description = "",
		position = 25,
		parent = "npcStub"
	)
	default Stub galvekStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "galvek",
		name = "Galvek",
		description = "Configures whether or not AoE Projectile Warnings for Galvek are displayed",
		parent = "galvekStub",
		position = 26
	)
	default boolean isGalvekEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "galveknotify",
		name = "Galvek Notify",
		description = "Configures whether or not AoE Projectile Warnings for Galvek should trigger a notification",
		parent = "galvekStub",
		position = 27,
		hide = "aoeNotifyAll"
	)
	default boolean isGalvekNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "gargbossStub",
		name = "Gargoyle Boss",
		description = "",
		position = 28,
		parent = "npcStub"
	)
	default Stub gargbossStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "gargboss",
		name = "Gargoyle Boss",
		description = "Configs whether or not AoE Projectile Warnings for Dawn/Dusk are displayed",
		parent = "gargbossStub",
		position = 29
	)
	default boolean isGargBossEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "gargbossnotify",
		name = "Gargoyle Boss Notify",
		description = "Configures whether or not AoE Projectile Warnings for Gargoyle Bosses should trigger a notification",
		parent = "gargbossStub",
		position = 30,
		hide = "aoeNotifyAll"
	)
	default boolean isGargBossNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "vetionStub",
		name = "Vet'ion",
		description = "",
		position = 31,
		parent = "npcStub"
	)
	default Stub vetionStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "vetion",
		name = "Vet'ion",
		description = "Configures whether or not AoE Projectile Warnings for Vet'ion are displayed",
		parent = "vetionStub",
		position = 32
	)
	default boolean isVetionEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "vetionnotify",
		name = "Vet'ion Notify",
		description = "Configures whether or not AoE Projectile Warnings for Vet'ion should trigger a notification",
		parent = "vetionStub",
		position = 33,
		hide = "aoeNotifyAll"
	)
	default boolean isVetionNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "chaosfanaticStub",
		name = "Chaos Fanatic",
		description = "",
		position = 34,
		parent = "npcStub"
	)
	default Stub chaosfanaticStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "chaosfanatic",
		name = "Chaos Fanatic",
		description = "Configures whether or not AoE Projectile Warnings for Chaos Fanatic are displayed",
		parent = "chaosfanaticStub",
		position = 35
	)
	default boolean isChaosFanaticEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "chaosfanaticnotify",
		name = "Chaos Fanatic Notify",
		description = "Configures whether or not AoE Projectile Warnings for Chaos Fanatic should trigger a notification",
		parent = "chaosfanaticStub",
		position = 36,
		hide = "aoeNotifyAll"
	)
	default boolean isChaosFanaticNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "olmStub",
		name = "Olm",
		description = "",
		position = 37,
		parent = "npcStub"
	)
	default Stub olmStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "olm",
		name = "Olm",
		description = "Configures whether or not AoE Projectile Warnings for The Great Olm are displayed",
		parent = "olmStub",
		position = 38
	)
	default boolean isOlmEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "olmnotify",
		name = "Olm Notify",
		description = "Configures whether or not AoE Projectile Warnings for Olm should trigger a notification",
		parent = "olmStub",
		position = 39,
		hide = "aoeNotifyAll"
	)
	default boolean isOlmNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "olmBombStub",
		name = "Bombs",
		description = "",
		position = 40,
		parent = "olmStub"
	)
	default Stub olmBombsStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "bombDisplay",
		name = "Olm Bombs",
		description = "Display a timer and colour-coded AoE for Olm's crystal-phase bombs.",
		parent = "olmBombStub",
		position = 41
	)
	default boolean bombDisplay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "bombDisplaynotify",
		name = "Olm Bombs Notify",
		description = "Configures whether or not AoE Projectile Warnings for Olm Bombs should trigger a notification",
		parent = "olmBombStub",
		position = 42,
		hide = "aoeNotifyAll"
	)
	default boolean bombDisplayNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "olmlightningStub",
		name = "Lightning Trails",
		description = "",
		position = 43,
		parent = "olmStub"
	)
	default Stub olmlightningStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "lightning",
		name = "Olm Lightning Trails",
		description = "Show Lightning Trails",
		parent = "olmlightningStub",
		position = 44
	)
	default boolean LightningTrail()
	{
		return true;
	}

	@ConfigItem(
		keyName = "lightningnotify",
		name = "Olm Lightning Trails Notify",
		description = "Configures whether or not AoE Projectile Warnings for Olm Lightning Trails should trigger a notification",
		parent = "olmlightningStub",
		position = 45,
		hide = "aoeNotifyAll"
	)
	default boolean LightningTrailNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "corpStub",
		name = "Corporeal Beast",
		description = "",
		position = 46,
		parent = "npcStub"
	)
	default Stub corpStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "corp",
		name = "Corporeal Beast",
		description = "Configures whether or not AoE Projectile Warnings for the Corporeal Beast are displayed",
		parent = "corpStub",
		position = 47
	)
	default boolean isCorpEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "corpnotify",
		name = "Corporeal Beast Notify",
		description = "Configures whether or not AoE Projectile Warnings for Corporeal Beast should trigger a notification",
		parent = "corpStub",
		position = 48,
		hide = "aoeNotifyAll"
	)
	default boolean isCorpNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "wintertodtStub",
		name = "Wintertodt",
		description = "",
		position = 49,
		parent = "npcStub"
	)
	default Stub wintertodtStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "wintertodt",
		name = "Wintertodt Snow Fall",
		description = "Configures whether or not AOE Projectile Warnings for the Wintertodt snow fall are displayed",
		parent = "wintertodtStub",
		position = 50
	)
	default boolean isWintertodtEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "wintertodtnotify",
		name = "Wintertodt Snow Fall Notify",
		description = "Configures whether or not AoE Projectile Warnings for Wintertodt Snow Fall Notify should trigger a notification",
		parent = "wintertodtStub",
		position = 51,
		hide = "aoeNotifyAll"
	)
	default boolean isWintertodtNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "xarpusStub",
		name = "Xarpus",
		description = "",
		position = 52,
		parent = "npcStub"
	)
	default Stub xarpusStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "isXarpusEnabled",
		name = "Xarpus",
		description = "Configures whether or not AOE Projectile Warnings for Xarpus are displayed",
		parent = "xarpusStub",
		position = 53
	)
	default boolean isXarpusEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "isXarpusEnablednotify",
		name = "Xarpus Notify",
		description = "Configures whether or not AoE Projectile Warnings for Xarpus should trigger a notification",
		parent = "xarpusStub",
		position = 54,
		hide = "aoeNotifyAll"
	)
	default boolean isXarpusNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "addyDragsStub",
		name = "Addy Drags",
		description = "",
		position = 55,
		parent = "npcStub"
	)
	default Stub addyDragsStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "addyDrags",
		name = "Addy Drags",
		description = "Show Bad Areas",
		parent = "addyDragsStub",
		position = 56
	)
	default boolean addyDrags()
	{
		return true;
	}

	@ConfigItem(
		keyName = "addyDragsnotify",
		name = "Addy Drags Notify",
		description = "Configures whether or not AoE Projectile Warnings for Addy Dragons should trigger a notification",
		parent = "addyDragsStub",
		position = 57,
		hide = "aoeNotifyAll"
	)
	default boolean addyDragsNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "drakeStub",
		name = "Drakes",
		description = "",
		position = 58,
		parent = "npcStub"
	)
	default Stub drakeStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "drake",
		name = "Drakes Breath",
		description = "Configures if Drakes Breath tile markers are displayed",
		parent = "drakeStub",
		position = 59
	)
	default boolean isDrakeEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "drakenotify",
		name = "Drakes Breath Notify",
		description = "Configures whether or not AoE Projectile Warnings for Drakes Breath should trigger a notification",
		parent = "drakeStub",
		position = 60,
		hide = "aoeNotifyAll"
	)
	default boolean isDrakeNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "cerberusStub",
		name = "Cerberus",
		description = "",
		position = 61,
		parent = "npcStub"
	)
	default Stub cerberusStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "cerbFire",
		name = "Cerberus Fire",
		description = "Configures if Cerberus fire tile markers are displayed",
		parent = "cerberusStub",
		position = 62
	)
	default boolean isCerbFireEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "cerbFirenotify",
		name = "Cerberus Fire Notify",
		description = "Configures whether or not AoE Projectile Warnings for Cerberus his fire should trigger a notification",
		parent = "cerberusStub",
		position = 63,
		hide = "aoeNotifyAll"
	)
	default boolean isCerbFireNotifyEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "demonicGorillaStub",
		name = "Demonic Gorilla",
		description = "",
		position = 64,
		parent = "npcStub"
	)
	default Stub demonicGorillaStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "demonicGorilla",
		name = "Demonic Gorilla",
		description = "Configures if Demonic Gorilla boulder tile markers are displayed",
		parent = "demonicGorillaStub",
		position = 65
	)
	default boolean isDemonicGorillaEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "demonicGorillaNotify",
		name = "Demonic Gorilla Notify",
		description = "Configures whether or not AoE Projectile Warnings for Demonic Gorilla boulders should trigger a notification",
		parent = "demonicGorillaStub",
		position = 66,
		hide = "aoeNotifyAll"
	)
	default boolean isDemonicGorillaNotifyEnabled()
	{
		return false;
	}
}