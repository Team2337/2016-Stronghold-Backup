package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import com.team254.frc2014.subsystems.Drivebase;
//import com.team254.lib.util.Util;
//import edu.wpi.first.wpilibj.DriverStation;

/**
 * CheesyDriveHelper implements the calculations used in CheesyDrive, sending power to the motors.
 */
public class CheesyDriveHelper extends Command {
	
	
  private double sensitivityLow = 1.0;    //Constants.sensitivityLow.getDouble()
  private double sensitivityHigh = 1.0;   //Constants.sensitivityHigh.getDouble()

  //private Drivebase drive;
  double oldWheel, quickStopAccumulator;
  private double throttleDeadband = 0.02;
  private double wheelDeadband = 0.02;
  
  double wheelNonLinearity;
  
  double leftPwm, rightPwm, overPower;
  double sensitivity;

  double angularPower;
  double linearPower;
  
  double negInertiaScalar;
  double negInertia;
  double negInertiaPower;
  double alpha;
  
  double negInertiaAccumulator = 0.0;   //  move set to 0 to init????****************************************

  
  double wheel, throttle;
  boolean isQuickTurn, isHighGear;
  private Joystick joystickMain = Robot.oi.driverJoystick;

  public CheesyDriveHelper() {    //(Drivebase drive) {
  //  this.drive = drive;
	  requires(Robot.chassisPID);
  }

  /*
  public void cheesyDrive(double throttle, double wheel, boolean isQuickTurn, boolean isHighGear) {
    //if (DriverStation.getInstance().isAutonomous()) {
    //  return;    }

  }
  */

  protected void initialize() {	  
	  
	  
  }

  protected void execute() {
	  
	  // get  (boolean isQuickTurn, boolean isHighGear)	  *******************
		throttle = -joystickMain.getRawAxis(1);
		wheel = joystickMain.getRawAxis(4);
		isHighGear = Robot.chassisShifter.getShiftStatus();
		isQuickTurn = joystickMain.getRawButton(10);


	    wheel = handleDeadband(wheel, wheelDeadband);
	    throttle = handleDeadband(throttle, throttleDeadband);

	    
	    negInertia = wheel - oldWheel;
	    oldWheel = wheel;

	    if (isHighGear) {
	      wheelNonLinearity = 0.6;
	      // Apply a sin function that's scaled to make it feel better.
	      wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel)
	              / Math.sin(Math.PI / 2.0 * wheelNonLinearity);
	      wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel)
	              / Math.sin(Math.PI / 2.0 * wheelNonLinearity);
	    } else {
	      wheelNonLinearity = 0.5;
	      // Apply a sin function that's scaled to make it feel better.
	      wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel)
	              / Math.sin(Math.PI / 2.0 * wheelNonLinearity);
	      wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel)
	              / Math.sin(Math.PI / 2.0 * wheelNonLinearity);
	      wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel)
	              / Math.sin(Math.PI / 2.0 * wheelNonLinearity);
	    }


	    // Negative inertia!
	    //double negInertiaAccumulator = 0.0;    moved to top, does this need to be here to reset to zero???******

	    //negInertiaAccumulator = 0.0;
	    
	    if (isHighGear) {
	      negInertiaScalar = 5.0;
	      sensitivity = sensitivityHigh;
	    } else {
	      if (wheel * negInertia > 0) {
	        negInertiaScalar = 2.5;
	      } else {
	        if (Math.abs(wheel) > 0.65) {
	          negInertiaScalar = 5.0;
	        } else {
	          negInertiaScalar = 3.0;
	        }
	      }
	      sensitivity = sensitivityLow;
	    }
	    negInertiaPower = negInertia * negInertiaScalar;
	    negInertiaAccumulator += negInertiaPower;

	    wheel = wheel + negInertiaAccumulator;
	    if (negInertiaAccumulator > 1) {
	      negInertiaAccumulator -= 1;
	    } else if (negInertiaAccumulator < -1) {
	      negInertiaAccumulator += 1;
	    } else {
	      negInertiaAccumulator = 0;
	    }
	    linearPower = throttle;
	    
	    //SmartDashboard.putNumber("Neg Inertia Acc", negInertiaAccumulator);
	    
	    //SmartDashboard.putNumber("linear Power", linearPower);

	    // Quickturn!
	    if (isQuickTurn) {
	      if (Math.abs(linearPower) < 0.2) {
	        alpha = 0.1;
	        quickStopAccumulator = (1 - alpha) * quickStopAccumulator + alpha
	                * this.limit(wheel, 1.0) * 5;      //   * Util.limit(wheel, 1.0) * 5;
	      
	        // SmartDashboard.putNumber("quickStopAccumulator", quickStopAccumulator);
	      
	      }
	      overPower = 1.0;
	      if (isHighGear) {
	        sensitivity = 1.0;
	      } else {
	        sensitivity = 1.0;
	      }
	      angularPower = wheel;
	    } else {
	      overPower = 0.0;
	      angularPower = Math.abs(throttle) * wheel * sensitivity - quickStopAccumulator;
	      if (quickStopAccumulator > 1) {
	        quickStopAccumulator -= 1;
	      } else if (quickStopAccumulator < -1) {
	        quickStopAccumulator += 1;
	      } else {
	        quickStopAccumulator = 0.0;
	      }
	    }
	    	//SmartDashboard.putNumber("Angular pPower", angularPower);
	    	//SmartDashboard.putNumber("throttle Power", throttle);
	    	//SmartDashboard.putNumber("wheel Power", wheel);
	    	//SmartDashboard.putNumber("sensitivity", sensitivity);
	    	//SmartDashboard.putNumber("quickStopAccumulator2", quickStopAccumulator);
	    	
	    	
	    rightPwm = leftPwm = linearPower;
	    leftPwm -= angularPower;
	    rightPwm += angularPower;

	    if (leftPwm > 1.0) {
	      rightPwm -= overPower * (leftPwm - 1.0);
	      leftPwm = 1.0;
	    } else if (rightPwm > 1.0) {
	      leftPwm -= overPower * (rightPwm - 1.0);
	      rightPwm = 1.0;
	    } else if (leftPwm < -1.0) {
	      rightPwm += overPower * (-1.0 - leftPwm);
	      leftPwm = -1.0;
	    } else if (rightPwm < -1.0) {
	      leftPwm += overPower * (-1.0 - rightPwm);
	      rightPwm = -1.0;
	    }
	    
	    
	    RobotMap.chassisDrive.setLeftRightMotorOutputs(leftPwm, rightPwm);

  }

  protected boolean isFinished() {
	
	return false;
  }

  protected void end() {
	
  }

  protected void interrupted() {
	
  }
  /**
   *  Returns 0 if the value is within the given deadband.
   */
  public double handleDeadband(double val, double deadband) {
    return (Math.abs(val) > Math.abs(deadband)) ? val : 0.0;
  }
  
  /**
   * Limits the given input to the given magnitude.
   */
  public double limit(double v, double limit) {    //static
	  
    return (Math.abs(v) < limit) ? v : limit * (v < 0 ? -1 : 1);
  }


}
