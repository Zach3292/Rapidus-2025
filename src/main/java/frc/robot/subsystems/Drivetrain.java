// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private VictorSPX backLeftMotor;
  private VictorSPX backRightMotor;
  private VictorSPX frontLeftMotor;
  private VictorSPX frontRightMotor;

  public Drivetrain() {
    backLeftMotor = new VictorSPX(Constants.CanIDs.backLeftMotor);
    backRightMotor = new VictorSPX(Constants.CanIDs.backRightMotor);
    frontLeftMotor = new VictorSPX(Constants.CanIDs.frontLeftMotor);
    frontRightMotor = new VictorSPX(Constants.CanIDs.frontRightMotor);

    backLeftMotor.setInverted(false);
    backRightMotor.setInverted(true);
    frontLeftMotor.setInverted(false);
    frontRightMotor.setInverted(false);

    frontLeftMotor.setNeutralMode(NeutralMode.Brake);
    frontRightMotor.setNeutralMode(NeutralMode.Brake);
    backLeftMotor.setNeutralMode(NeutralMode.Brake);
    backRightMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void driveTank(double leftSpeed, double rightSpeed) {
    backLeftMotor.set(ControlMode.PercentOutput, leftSpeed);
    backRightMotor.set(ControlMode.PercentOutput, rightSpeed);
    frontLeftMotor.set(ControlMode.PercentOutput, leftSpeed);
    frontRightMotor.set(ControlMode.PercentOutput, rightSpeed);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
