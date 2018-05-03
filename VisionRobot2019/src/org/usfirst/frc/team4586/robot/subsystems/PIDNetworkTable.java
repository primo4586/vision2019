package org.usfirst.frc.team4586.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class PIDNetworkTable implements PIDSource {
	private NetworkTable table;

	public PIDNetworkTable(NetworkTable table) {
		// TODO Auto-generated constructor stub
		this.table = table;
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// TODO Auto-generated method stub

	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		return table.getEntry("angle").getDouble(0.0);
	}

}
