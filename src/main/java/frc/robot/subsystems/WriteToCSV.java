package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileWriter;


public class WriteToCSV extends SubsystemBase{
    public void robotInit() {
    	try {
    		File writer = new File("/home/lvuser/launcher.csv");
            writer.write(String.format("%f,%f,%f\n", m_launcher.getCurrentRpm(), m_targeting.calcDistance()));
            writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();       
		}
    }
}
