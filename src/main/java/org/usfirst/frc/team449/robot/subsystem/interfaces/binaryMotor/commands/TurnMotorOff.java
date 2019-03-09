package org.usfirst.frc.team449.robot.subsystem.interfaces.binaryMotor.commands;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.shuffleboard.EventImportance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import org.jetbrains.annotations.NotNull;
import org.usfirst.frc.team449.robot.subsystem.interfaces.binaryMotor.SubsystemBinaryMotor;

/**
 * Turns off the motor of the specified subsystem.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class)
public class TurnMotorOff extends InstantCommand {

    /**
     * The subsystem to execute this command on.
     */
    @NotNull
    protected final SubsystemBinaryMotor subsystem;

    /**
     * Default constructor
     *
     * @param subsystem The subsystem to execute this command on.
     */
    @JsonCreator
    public TurnMotorOff(@NotNull @JsonProperty(required = true) SubsystemBinaryMotor subsystem) {
        this.subsystem = subsystem;
    }

    /**
     * Log when this command is initialized
     */
    @Override
    protected void initialize() {
        Shuffleboard.addEventMarker("TurnMotorOff init.", this.getClass().getSimpleName(), EventImportance.kNormal);
        //Logger.addEvent("TurnMotorOff init.", this.getClass());
    }

    /**
     * Turn the motor off.
     */
    @Override
    protected void execute() {
        subsystem.turnMotorOff();
    }

    /**
     * Log when this command ends
     */
    @Override
    protected void end() {
        Shuffleboard.addEventMarker("TurnMotorOff end.", this.getClass().getSimpleName(), EventImportance.kNormal);
        //Logger.addEvent("TurnMotorOff end.", this.getClass());
    }

    /**
     * Log when this command is interrupted.
     */
    @Override
    protected void interrupted() {
        Shuffleboard.addEventMarker("TurnMotorOff Interrupted!", this.getClass().getSimpleName(), EventImportance.kNormal);
        //Logger.addEvent("TurnMotorOff Interrupted!", this.getClass());
    }
}