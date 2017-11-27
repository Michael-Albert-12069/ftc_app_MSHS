package org.firstinspires.ftc.teamcode;

/**
 * Created by michaelalbert on 10/15/17.
 */
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by michaelalbert on 10/14/17.
 */
@TeleOp(name = "Michael - TeleOp Tank claw", group = "TeleOp")
public class TankDrive extends LinearOpMode {
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

            double leftspeed = Math.round(-gamepad1.left_stick_y*10);
            double leftspeedinput = leftspeed/10;

            double rightspeed = Math.round(-gamepad1.right_stick_y*10);
            double rightspeedinput = rightspeed/10;

            rightmotor.setPower(rightspeedinput);
            leftmotor.setPower(leftspeedinput);

            telemetry.update();
            idle();
        }
    }
}