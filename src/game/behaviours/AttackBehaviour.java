package game.behaviours;

import edu.monash.fit2099.engine.*;
import game.actions.AttackAction;
import game.enums.Status;
import game.interfaces.Behaviour;

import java.util.Random;

/**
 * A class that figures out a AttackAction that will causes the actor to attack the target Actor.
 *
 * @see edu.monash.fit2099.engine
 * @see AttackAction
 * @see Status
 * @see Behaviour
 * @see Random
 */

public class AttackBehaviour implements Behaviour {

    /**
     * A random number generator
     */
    private Random random = new Random();

    @Override
    public Action getAction(Actor actor, GameMap map) {
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor otherActor = destination.getActor();
                if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    Actions actions = new Actions();
                    // add active skills of the actor's weapon
                    actions.add(actor.getWeapon().getActiveSkill(otherActor, exit.getName()));
                    // add normal attack
                    actions.add(new AttackAction(otherActor, exit.getName()));
                    // randomly choose from using active skill to attack or perform normal attack
                    return actions.get(random.nextInt(actions.size()));
                }
            }
        }
        return null;
    }
}
