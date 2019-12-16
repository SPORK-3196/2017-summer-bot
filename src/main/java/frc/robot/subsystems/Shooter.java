/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.RunShooter;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX ballStorageMotor = new WPI_TalonSRX(5);
  public WPI_TalonSRX preShooterMotor = new WPI_TalonSRX(8);
  public WPI_TalonSRX flywheelMotor = new WPI_TalonSRX(6);
  public WPI_TalonSRX turretRotationMotor = new WPI_TalonSRX(9);

  SpeedControllerGroup ballStorageSystem = new SpeedControllerGroup(ballStorageMotor, preShooterMotor);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    setDefaultCommand(new RunShooter());
  }
}
