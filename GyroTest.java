package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.hitechnic.HiTechnicNxtAccelerationSensor;
import com.qualcomm.hardware.hitechnic.HiTechnicNxtGyroSensor;
import com.qualcomm.hardware.hitechnic.HiTechnicNxtLightSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.LegacyModule;

@TeleOp(name = "Gyro Test", group = "Test")
public class GyroTest extends OpMode {
    HiTechnicNxtGyroSensor a;
    LegacyModule lm;
    HiTechnicNxtLightSensor light;

    public void init (){
        lm = hardwareMap.legacyModule.get("AL00XR6U");
        a = new HiTechnicNxtGyroSensor (lm,1);
        light = new HiTechnicNxtLightSensor(lm,5);
        //accel = new HiTechnicNxtAccelerationSensor(lm, );

    }

    public void loop(){
        telemetry.addData ("RF:", a.getRotationFraction());
        telemetry.addData ("Light:", light.getLightDetected());

        // telemetry.addData ("Y:", a.rawY());
       // telemetry.addData ("Z:", a.rawZ());
    }
}
