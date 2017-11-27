package org.firstinspires.ftc.teamcode;

/**
 * Created by michaelalbert on 10/15/17.
 */
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by michaelalbert on 10/14/17.
 */
@TeleOp(name = "Michael - TeleOp Tank ServoArm", group = "TeleOp")
//@Disabled
public class TankDriveWithEncoders extends LinearOpMode {
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private DcMotor armmotor;
    private Servo armclaw;

    @Override
    public void runOpMode() throws InterruptedException {

        leftmotor = hardwareMap.dcMotor.get("leftmotor");
        rightmotor = hardwareMap.dcMotor.get("rightmotor");
        leftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armmotor = hardwareMap.dcMotor.get("arm");
        armmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armclaw = hardwareMap.servo.get("armclaw");
        leftmotor.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();
        while ((opModeIsActive())) {
            armclaw.setPosition(128);
            //servo left max= 0; close = 140
            //servo right max= 145; close = 0

            double armpower= gamepad2.right_trigger/5;
            armmotor.setPower(armpower);


            if(gamepad2.a){
//            open
armclaw.setPosition(250);
            }
//            close
            if(gamepad2.b){
armclaw.setPosition(200);
            }



            double leftspeed = Math.round(-gamepad1.left_stick_y* 10);
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