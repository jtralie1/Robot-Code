package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by UDRI1 on 7/28/2016.
 *  Simple Tank Drive Program*/
public class omniWheel extends OpMode {
    // Declare Motor Variables
    DcMotor lfmotor;
    DcMotor rfmotor;
    DcMotor lbmotor;
    DcMotor rbmotor;

    @Override
    public void init() {
        // Map Motor Variables to Hardware on robot using Hardware Map
        lfmotor = hardwareMap.dcMotor.get("left_front_motor");
        rfmotor = hardwareMap.dcMotor.get("right_front_motor");
        rbmotor = hardwareMap.dcMotor.get("right_back_motor");
        lbmotor = hardwareMap.dcMotor.get("left_back_motor");
// Right motor is mounted backwards from left motor so reverse its direction
        rfmotor.setDirection(DcMotor.Direction.REVERSE);
        rbmotor.setDirection(DcMotor.Direction.REVERSE);


    }

    @Override
    public void loop() {
        // Read gamepad values and set motor power to them (negative sign is used since pushing forward
        //   on stick gives a negative value
        boolean forward = gamepad1.dpad_up;
        boolean backward = gamepad1.dpad_down;
        boolean left = gamepad1.dpad_left;
        boolean right = gamepad1.dpad_right;
        //Trying to configure how to turn left and right
        boolean turnRight = gamepad1.left_bumper;
        boolean turnLeft = gamepad1.right_bumper;

        while(forward){
            lbmotor.setPower(1);
            lfmotor.setPower(1);
            rbmotor.setPower(1);
            rfmotor.setPower(1);
        }
        while(backward){
            lbmotor.setPower(-1);
            lfmotor.setPower(-1);
            rbmotor.setPower(-1);
            rfmotor.setPower(-1);
        }
        while(left){
            lbmotor.setPower(1);
            lfmotor.setPower(-1);
            rbmotor.setPower(1);
            rfmotor.setPower(-1);
        }
        while(right){
            lbmotor.setPower(-1);
            lfmotor.setPower(1);
            rbmotor.setPower(-1);
            rfmotor.setPower(1);
        }
        while(turnLeft){
            lbmotor.setPower(-1);
            lfmotor.setPower(-1);
            rbmotor.setPower(1);
            rfmotor.setPower(1);
        }
        while(turnRight){
            lbmotor.setPower(1);
            lfmotor.setPower(1);
            rbmotor.setPower(-1);
            rfmotor.setPower(-1);
        }

        telemetry.addData( "01", "Left Drive: " + left);
        telemetry.addData( "02", "Right Drive: " + right);
        telemetry.addData( "03", "Forward Drive: " + forward);
        telemetry.addData( "04", "Backward Drive: " + backward);
        telemetry.addData("05", "Turn Left: " + turnLeft);
        telemetry.addData("06", "Turn Right: " + turnRight);

    }

}
