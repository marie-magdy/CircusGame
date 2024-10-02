/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import Strategy.Strategy;
import Strategy.StrategyType;
import static Strategy.StrategyType.EASY;
import static Strategy.StrategyType.HARD;
import Strategy.easyLevel;
import Strategy.hardLevel;
import Strategy.mediumLevel;
import static java.text.DateFormat.MEDIUM;

/**
 *
 * @author Sama
 */
public class StrategyFactory {

    public Strategy getLevel(StrategyType type) {
        if (null != type) {
            switch (type) {
                case EASY:
                    return new easyLevel();
                case MEDIUM:
                    return new mediumLevel();
                case HARD:
                    return new hardLevel();
                default:
                    break;
            }
        }
        return null;
    }
}
