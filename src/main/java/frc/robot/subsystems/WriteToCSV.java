package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToCSV extends SubsystemBase {
	final String m_Filename = "/home/lvuser/match_data.csv";
	final boolean m_Append = false;
	BufferedWriter m_File;

	public WriteToCSV() {
		System.out.println("Initializing log file.");

		try {
			// Open File
			FileWriter fstream = new FileWriter(m_Filename, m_Append);
			m_File = new BufferedWriter(fstream);


			//Write the header
			writeHeader();

			System.out.println("Opened log file at " + m_Filename);
		} catch (Exception e) {
			System.out.println("Failed to open log file. " + m_Filename);
		}
	}

	private void writeHeader() {
        String stringToWrite = "ID, Time, TriggerMotorSet, BeltMotorSet, RpmSet, CurrentRpm, LauncherReady, DistanceToTarget, AngleToTargetDeg, IsTargeted\n";
        writeToFile(stringToWrite);
    }

	// Writes a string to the data file.
	// Returns true if successful, false otherwise
	public boolean writeToFile(String stringToWrite) {
		boolean retval = true;

		try {
			// Write string to file
			m_File.append(stringToWrite);
		} catch (Exception e) {
			// Failed to write
			retval = false;
		}

		return retval;
	}
}
