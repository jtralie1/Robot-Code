package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by UDRI1 on 11/30/2016.
 */
@TeleOp(name = "servo test", group = "Test")
public class servoTest extends OpMode{

    Servo servo;
    double position = 0.00000;

    public void init (){
        servo = hardwareMap.servo.get ("servo");

    }

    public void loop (){
        if (gamepad1.dpad_up){
                servo.setPosition(.2);
        }
        if (gamepad1.dpad_down){
                servo.setPosition(.75);
            }
        telemetry.addData("pos: ", position);
        telemetry.addData("up or down: ", gamepad1.dpad_down + " " + gamepad1.dpad_up);

    }
}
