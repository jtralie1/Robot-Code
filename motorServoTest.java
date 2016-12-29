package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by UDRI1 on 10/5/2016.
 */
public class motorServoTest extends OpMode{
    Servo open;
    Servo close;
    DcMotor testMotor;

    public void init(){
        open = hardwareMap.servo.get("servo_open");
        close = hardwareMap.servo.get("servo_close");
        testMotor = hardwareMap.dcMotor.get("test_motor_run");
    }

    public void loop(){
        boolean isClose = gamepad1.a;
        boolean isOpen = gamepad1.x;
        boolean forward = gamepad1.dpad_up;

        while(isOpen){
            open.setPosition(100);
        }

        while(isClose){
            close.setPosition(0);
        }

        while(forward){
            testMotor.setPower(1);
        }

    }

}
