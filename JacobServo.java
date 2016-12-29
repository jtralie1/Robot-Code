package com.qualcomm.robotcore.eventloop.opmode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by UDRI1 on 11/16/2016.
 */

@TeleOp(name = "motorServoTest", group = "Test")
public class JacobServo extends OpMode{

    Servo servo1;

    public void init(){

        servo1 = hardwareMap.servo.get("servo1");

    }

    public void loop(){

        if(gamepad1.x)
            servo1.setPosition(.5);

        if(gamepad1.a)
            servo1.setPosition(0);

    }

}
