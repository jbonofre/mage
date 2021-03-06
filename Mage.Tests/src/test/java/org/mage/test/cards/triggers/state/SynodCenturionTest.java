/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mage.test.cards.triggers.state;

import mage.constants.PhaseStep;
import mage.constants.Zone;
import mage.counters.CounterType;
import org.junit.Test;
import org.mage.test.serverside.base.CardTestPlayerBase;

/**
 *
 * @author LevelX2
 */

public class SynodCenturionTest extends CardTestPlayerBase {


    /**
     * Check that Synod Centurion gets sacrificed if no other artifacts are on the battlefield
     * 
     */
    @Test
    public void testAlone() {
        addCard(Zone.BATTLEFIELD, playerA, "Mountain", 6);
        addCard(Zone.BATTLEFIELD, playerA, "Demon's Horn");
        addCard(Zone.HAND, playerA, "Shatter");
        addCard(Zone.HAND, playerA, "Synod Centurion");

        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "Synod Centurion");
        castSpell(1, PhaseStep.POSTCOMBAT_MAIN, playerA, "Shatter", "Demon's Horn");

        setStopAt(1, PhaseStep.END_TURN);
        execute();

        assertGraveyardCount(playerA, "Demon's Horn", 1);
        assertGraveyardCount(playerA, "Shatter", 1);
        assertGraveyardCount(playerA, "Synod Centurion", 1);
    }

    /**
     * Check that Synod Centurion gets sacrificed if the only other
     * artifact left the battlefiled for a short time
     * 
     */
    @Test
    public void testWithFlicker() {
        addCard(Zone.BATTLEFIELD, playerA, "Plains", 6);
        addCard(Zone.BATTLEFIELD, playerA, "Bottle Gnomes");
        addCard(Zone.HAND, playerA, "Cloudshift");
        addCard(Zone.HAND, playerA, "Synod Centurion");

        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "Synod Centurion");
        castSpell(1, PhaseStep.POSTCOMBAT_MAIN, playerA, "Cloudshift", "Bottle Gnomes");

        setStopAt(1, PhaseStep.END_TURN);
        execute();

        assertPermanentCount(playerA, "Bottle Gnomes", 1);
        assertGraveyardCount(playerA, "Cloudshift", 1);
        assertGraveyardCount(playerA, "Synod Centurion", 1);
    }    
}