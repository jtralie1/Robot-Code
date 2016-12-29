package com.qualcomm.robotcore.eventloop.opmode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
// import src.main.java.org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//@ FtcRobotContoller.libs.RobotCore-release-sources.jar.com.qualcomm.robotcore.eventloop.opmode.TeleOp;
/**
 * Created by UDRI1 on 7/28/2016.
 *  Simple Tank Drive Program*/
@TeleOp(name = "Simple Drive", group = "Test")
public class SimpleDrive extends OpMode {

    // Declare Motor Variables

    DcMotor leftmotor;
    DcMotor rightmotor;
    DcMotor leftmotor1;
    DcMotor rightmotor1;

    @Override



    public void init() {
        // Map Motor Variables to Hardware on robot using Hardware Map
        leftmotor = hardwareMap.dcMotor.get("left_front_motor");
        rightmotor = hardwareMap.dcMotor.get("right_front_motor");
        leftmotor1 = hardwareMap.dcMotor.get("left_back_motor");
        rightmotor1 = hardwareMap.dcMotor.get("right_back_motor");


// Right motor is mounted backwards from left motor so reverse its direction
        rightmotor.setDirection(DcMotor.Direction.REVERSE);
        rightmotor1.setDirection(DcMotor.Direction.REVERSE);



    }

    public void start () {

    }

    @Override
    public void loop() {
        //Code so we can use the Dpad to drive around
        /*boolean forward = gamepad1.dpad_up;
        boolean backward = gamepad1.dpad_down;
        boolean left = gamepad1.dpad_left;
        boolean right = gamepad1.dpad_right;*/

        //Code to use power multiplier
        boolean power = gamepad1.left_stick_button;
        double PowerMult;

        /*leftmotor.setPower(0);
        leftmotor1.setPower(0);
        rightmotor.setPower(0);
        rightmotor1.setPower(0);*/

        float leftY = -gamepad1.left_stick_y;
        float rightY = -gamepad1.right_stick_y;

        //Code to set motor power to half by pushing a button
        if(power)
        {
            PowerMult = 0.5;
        }
        else
        {
            PowerMult = 1.0;
        }



        if(-0.3 < rightY && rightY < 0.3)
        {
            rightY = 0;
        }

        if(-0.3 < leftY && leftY< 0.3)
        {
            leftY = 0;
        }

        leftmotor.setPower(rightY / PowerMult);
        leftmotor1.setPower(rightY / PowerMult);
        rightmotor.setPower(leftY / PowerMult);
        rightmotor1.setPower(leftY / PowerMult);





        telemetry.addData
                ("01", "Left Motors Power: " + leftmotor.getPower());
        telemetry.addData
                ("02", "Right Motors Power: " + rightmotor.getPower());


        /*while(forward) {
            leftmotor.setPower(1);
            leftmotor1.setPower(1);
            rightmotor.setPower(1);
            rightmotor1.setPower(1);
            if(!forward){
                break;
            }
        }
        while(backward) {
            leftmotor.setPower(-1);
            leftmotor1.setPower(-1);
            rightmotor.setPower(-1);
            rightmotor1.setPower(-1);
            if(!)
        }

        else if(left) {
            leftmotor.setPower(-1);
            leftmotor1.setPower(-1);
            rightmotor.setPower(1);
            rightmotor1.setPower(1);
        }

        else if(right) {
            leftmotor.setPower(1);
            leftmotor1.setPower(1);
            rightmotor.setPower(-1);
            rightmotor1.setPower(-1);
        }
        else {
            leftmotor.setPower(0);
            leftmotor1.setPower(0);
            rightmotor.setPower(0);
            rightmotor1.setPower(0);
        }*/



    }

}
