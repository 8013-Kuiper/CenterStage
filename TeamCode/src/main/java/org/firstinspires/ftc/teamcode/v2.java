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

@TeleOp
public class v2 extends driveConstant {

    enum State{
        start,
        accel,
        end,
        rest,
    };
    public void runOpMode() {
        initdrivetrain();
        State state = State.rest;
        ElapsedTime timer = new ElapsedTime();
        double speed = 0;
        double curentspeed = 0;
        double distance = 0;
        waitForStart();


        while (opModeIsActive()) {
            frontLeft.setPower(speed);
            frontRight.setPower(speed * .97);
            backLeft.setPower(speed);
            backRight.setPower(speed * .97);


            switch (state){
                case start:
                    speed=-.1;
                    timer.reset();
                    state = State.accel;
                case accel:
                    if(timer.seconds()>1){
                        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                        state = State.end;
                    }
                case end:
                    if(timer.seconds()>2){
                        speed=0;
                        distance=((frontLeft.getCurrentPosition()/2000)*150.79);
                        //telemetry.addData("distance mm", distance);
                        telemetry.update();
                        state = State.rest;
                    }
                case rest:
                    if (gamepad1.y)
                        state = State.start;
            }


            telemetry.addData("state:",state);
            telemetry.addData("timer", timer);
            telemetry.addData("distance(mm)",distance);
            telemetry.addData("rawdis", frontLeft.getCurrentPosition());
            telemetry.update();
        }

    }
}
