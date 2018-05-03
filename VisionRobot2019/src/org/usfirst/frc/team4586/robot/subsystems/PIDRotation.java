package org.usfirst.frc.team4586.robot.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;

public class PIDRotation implements PIDOutput {
	private double rotation;

	public PIDRotation() {
		// TODO Auto-generated constructor stub
		this.rotation = 0;
	}

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		this.rotation = output;
	}

	public double getRotation() {
		return this.rotation;
	}

}
