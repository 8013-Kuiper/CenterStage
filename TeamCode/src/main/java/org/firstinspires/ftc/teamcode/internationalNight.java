package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;                //imports from FIRST
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.robotcore.internal.camera.delegating.DelegatingCaptureSequence;
import org.opencv.features2d.BRISK;

@TeleOp


public class internationalNight extends driveConstant {

    enum State{
        firstPixel,
        backwards,
        dump,
        reset,
        up
    }
    @Override
    public void runOpMode() {
        initrobot();
        initdrivetrain();

        State state = State.reset;
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        waitForStart();

        while (opModeIsActive()) {

            if (mRuntime.seconds()<1)
                outTake.setPosition(.7);
            if (mRuntime.seconds()>1)
                outTake.setPosition(.4);
            if (mRuntime.seconds()>2)
                mRuntime.reset(); 
            telemetry.addData("sdf",mRuntime);
            telemetry.update();
        }

    }
    public ElapsedTime mRuntime = new ElapsedTime();

}
