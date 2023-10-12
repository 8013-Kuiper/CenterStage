package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import org.openftc.easyopencv.OpenCvCamera;


public abstract class DriveConstants extends OpMode {

    public DcMotor frontLeft;
    public DcMotor frontRight;                                         //Declaring Motor varibles
    public DcMotor backLeft;
    public DcMotor backRight;

    public DcMotor Crane;

    public OpenCvCamera webcam;


    public void initrobot() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");                            //mapping motors from control hub
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");



        Crane = hardwareMap.get(DcMotor.class,"crane");

        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);                 //setting direction of drive train
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);


        Crane.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


    }
}
