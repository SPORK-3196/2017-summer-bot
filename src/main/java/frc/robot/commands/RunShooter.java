/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class RunShooter extends Command {
  public RunShooter() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    requires(Robot.shooter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double rightTrigger = Robot.controller0.getTriggerAxis(Hand.kRight);

    Robot.shooter.ballStorageMotor.set(rightTrigger * (1.0));
    Robot.shooter.preShooterMotor.set(rightTrigger * (-1.0));
    Robot.shooter.flywheelMotor.set(rightTrigger * (1.0));

    double rightX = Robot.controller0.getX(Hand.kRight);

    Robot.shooter.turretRotationMotor.set(rightX * (0.5));

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
