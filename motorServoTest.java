package com.qualcomm.robotcore.eventloop.opmode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by UDRI1 on 10/5/2016.
 */
@TeleOp(name = "motorServoTest1", group = "Test")
public class motorServoTest extends OpMode{
    Servo open;
  //  Servo closed;
/*
    final double LEFT_OPEN_POS = 256;
    final double LEFT_CLOSED_POS = 128;
    //final double RIGHT
*/

    DcMotor testMotor;

    public void init(){
        open = hardwareMap.servo.get("servo_open");
        //closed = hardwareMap.servo.get("servo_closed");

        //testMotor = hardwareMap.dcMotor.get("test_motor_run");
    }

    public void loop(){


        boolean isOpen = gamepad1.x;
        boolean isClosed = gamepad1.y;
        //boolean isClosed = gamepad1.y;
        // boolean forward = gamepad1.dpad_up;

        if(isOpen) {
            open.setPosition(1);
            //closed.setPosition(LEFT_OPEN_POS);
        }
        else if(isClosed){
            open.setPosition(0);
        }
        else {
            open.setPosition(.5);
        }
            //closed.setPosition(LEFT_CLOSED_POS);
        // if(isClosed){
         //   open.setPosition(LEFT_CLOSED_POS);
       // }
        //telemetry.addData("01", "isOpen = ", isOpen);
/*
        if(forward){
            testMotor.setPower(1);
        }
*/
    }

}
