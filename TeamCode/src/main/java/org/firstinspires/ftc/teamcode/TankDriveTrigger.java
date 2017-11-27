package org.firstinspires.ftc.teamcode;

/**
 * Created by michaelalbert on 10/15/17.
 */
import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by michaelalbert on 10/14/17.
 */
@TeleOp(name = "Michael - TriggerWarning", group = "TeleOp")
public class TankDriveTrigger extends LinearOpMode {
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private int targetposition;

    @Override
    public void runOpMode() throws InterruptedException {

        leftmotor = hardwareMap.dcMotor.get("leftmotor");
        rightmotor = hardwareMap.dcMotor.get("rightmotor");


        leftmotor.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();
        while ((opModeIsActive())) {
            double trigger = gamepad1.right_trigger * 2;
            double leftspeed = -gamepad1.left_stick_y /2;
            double leftspeedinput = leftspeed * trigger;

            double rightspeed = -gamepad1.right_stick_y/2;
            double rightspeedinput = rightspeed * trigger;

            rightmotor.setPower(rightspeedinput);
            leftmotor.setPower(leftspeedinput);

            telemetry.update();
            idle();
        }



    }
}