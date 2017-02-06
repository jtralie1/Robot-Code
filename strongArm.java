package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by UDRI1 on 1/3/2017.
 */

@TeleOp(name = "Arm", group = "test")

public class strongArm extends OpMode
{

    //6 servos declared
    Servo shoulder;
    Servo rotator;
    Servo elbow;
    Servo wrist;
    Servo claw;
    Servo servo6;

    //ints for setting position
    public double shoulderpos;
    public double rotatorpos;
    public double elbowpos;
    public double wristpos;
    public double clawpos;
    public double servo6pos;

    public void init()
    {

        shoulderpos = shoulder.getPosition();
        rotatorpos = shoulder.getPosition();
        elbowpos = elbow.getPosition();
        wristpos = wrist.getPosition();
        clawpos = claw.getPosition();
        servo6pos = servo6.getPosition();

        shoulder = hardwareMap.servo.get("shoulder");
        rotator = hardwareMap.servo.get("rotator");
        elbow = hardwareMap.servo.get("elbow");
        wrist = hardwareMap.servo.get("wrist");
        claw = hardwareMap.servo.get("claw");
 //       flap = hardwareMap.servo.get("flap");
        servo6 = hardwareMap.servo.get("servo6");
        elbow.setDirection(Servo.Direction.REVERSE);

    }

    public void loop()
    {

        /*Plan to check for servo position
        at the start and then set them to that position,
        then be able to manipulate them based on their
        range of movement. --David Molish, 2/3/17
        */

        //binds booleans to buttons
        boolean moveShoulder = gamepad1.left_bumper;
        boolean moveRotator = gamepad1.dpad_up;
        boolean moveElbow = gamepad1.b;
        boolean moveWrist = gamepad1.dpad_left;
        boolean moveClaw = gamepad1.y;
        boolean moveservo6 = gamepad1.start;
        boolean reverseShoulder = gamepad1.right_bumper;
        boolean reverseRotator = gamepad1.dpad_down;
        boolean reverseElbow = gamepad1.a;
        boolean reverseWrist = gamepad1.dpad_right;
        boolean reverseClaw = gamepad1.x;
         boolean reverseservo6 = gamepad1.back;

        //makes buttons move da things
        if(moveShoulder){
            shoulder.setPosition(shoulderpos + 1);
        }
        if(reverseShoulder){

            shoulder.setPosition(shoulderpos);
        }
        if(moveRotator)
            rotator.setPosition(rotatorpos + 1);
        if(reverseRotator){

            rotator.setPosition(rotatorpos);
        }
        if(reverseElbow)
            elbow.setPosition(elbowpos + 1);
        if(moveElbow){

            elbow.setPosition(elbowpos);
        }
        if(moveWrist)
            wrist.setPosition(wristpos + 1);
        if(reverseWrist){

            wrist.setPosition(wristpos);
        }
        if(moveClaw)
            claw.setPosition(clawpos + 1);
        if(reverseClaw){

            claw.setPosition(clawpos);
        }
        if(moveservo6) {
            servo6.setPosition(servo6pos + 1);
        }
        if(reverseservo6){

            servo6.setPosition(servo6pos);
        }

    }
}
