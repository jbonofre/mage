/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.lorwyn;

import java.util.UUID;

import mage.constants.CardType;
import mage.constants.Rarity;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SpellCastControllerTriggeredAbility;
import mage.abilities.effects.common.continuous.BoostTargetEffect;
import mage.cards.CardImpl;
import mage.constants.Duration;
import mage.filter.FilterSpell;
import mage.filter.predicate.mageobject.SubtypePredicate;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author Loki
 */
public class ThorntoothWitch extends CardImpl {

    private static final FilterSpell filter = new FilterSpell("Treefolk");

    static {
        filter.add(new SubtypePredicate("Treefolk"));
    }

    public ThorntoothWitch(UUID ownerId) {
        super(ownerId, 144, "Thorntooth Witch", Rarity.UNCOMMON, new CardType[]{CardType.CREATURE}, "{5}{B}");
        this.expansionSetCode = "LRW";
        this.subtype.add("Treefolk");
        this.subtype.add("Shaman");
        this.color.setBlack(true);
        this.power = new MageInt(3);
        this.toughness = new MageInt(4);
        // Whenever you cast a Treefolk spell, you may have target creature get +3/-3 until end of turn.
        Ability ability = new SpellCastControllerTriggeredAbility(new BoostTargetEffect(3, -3, Duration.EndOfTurn), filter, true);
        ability.addTarget(new TargetCreaturePermanent());
        this.addAbility(ability);
    }

    public ThorntoothWitch(final ThorntoothWitch card) {
        super(card);
    }

    @Override
    public ThorntoothWitch copy() {
        return new ThorntoothWitch(this);
    }
}
