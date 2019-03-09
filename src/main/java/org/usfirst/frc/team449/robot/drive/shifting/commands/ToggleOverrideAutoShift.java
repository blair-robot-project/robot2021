package org.usfirst.frc.team449.robot.drive.shifting.commands;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.shuffleboard.EventImportance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import org.jetbrains.annotations.NotNull;
import org.usfirst.frc.team449.robot.drive.shifting.DriveShiftable;

import java.awt.*;

/**
 * Override or unoverride whether we're autoshifting. Used to stay in low gear for pushing matches and more!
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class)
public class ToggleOverrideAutoShift extends InstantCommand {

    /**
     * The drive subsystem to execute this command on.
     */
    @NotNull
    private final DriveShiftable subsystem;

    /**
     * Default constructor
     *
     * @param drive The drive subsystem to execute this command on.
     */
    @JsonCreator
    public ToggleOverrideAutoShift(@NotNull @JsonProperty(required = true) DriveShiftable drive) {
        subsystem = drive;
    }

    /**
     * Log on initialization
     */
    @Override
    protected void initialize() {
        Shuffleboard.addEventMarker("OverrideAutoShift init", this.getClass().getSimpleName(), EventImportance.kNormal);
        //Logger.addEvent("OverrideAutoShift init", this.getClass());
    }

    /**
     * Toggle overriding autoshifting.
     */
    @Override
    protected void execute() {
        //Set whether or not we're overriding
        subsystem.setOverrideAutoshift(!subsystem.getOverrideAutoshift());
    }

    /**
     * Log when this command ends.
     */
    @Override
    protected void end() {
        Shuffleboard.addEventMarker("OverrideAutoShift end", this.getClass().getSimpleName(), EventImportance.kNormal);
        //Logger.addEvent("OverrideAutoShift end", this.getClass());
    }

    /**
     * Log when interrupted
     */
    @Override
    protected void interrupted() {
        Shuffleboard.addEventMarker("OverrideAutoShift Interrupted!", this.getClass().getSimpleName(), EventImportance.kNormal);
        //Logger.addEvent("OverrideAutoShift Interrupted!", this.getClass());
    }
}

