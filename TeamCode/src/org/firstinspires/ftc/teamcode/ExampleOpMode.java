package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.*;

/*
Hello! This is an OpMode. Actually no, this is Trinity. Below is an OpMode.

Think of an OpMode like a session where we want to do a bunch of stuff.
Our Autonomous will be one OpMode.
TeleOp is a different OpMode, since we want to do different stuff.
 */
@Autonomous(name="ArmBot Example", group="ArmBot")
public class ExampleOpMode extends LinearOpMode {

    private DcMotor lf;
    private DcMotor lb;
    private DcMotor rf;
    private DcMotor rb;
    private BNO055IMU imu;
    private ColorSensor colorSensor;

    private DcMotor armMotor;
    private Servo handServo;

    /*
        This code runs once when we click INIT.
        We do all of our, well, init-ialization in here.
        This is like our "preload" time before we actually go/START.
        For an actual FTC game, the referees make you click INIT, then after they check
        everyone else, you press START.
    */
    public void onInit() {
        // this is how we access the "physical" devices of the robot through our code
        // probably don't touch this stuff-- I mean you totally can, but, what for??
        lb = hardwareMap.dcMotor.get("back_left_motor");
        lf = hardwareMap.dcMotor.get("front_left_motor");
        rf = hardwareMap.dcMotor.get("front_right_motor");
        rb = hardwareMap.dcMotor.get("back_right_motor");
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        armMotor = hardwareMap.dcMotor.get("arm_motor");
        handServo = hardwareMap.servo.get("hand_servo");
        colorSensor = hardwareMap.colorSensor.get("color_sensor");

        // can you tell what these do?
        armMotor.setDirection(DcMotor.Direction.FORWARD);
//        armMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    /*
    This code runs when we click START.

    Remember that all the code will run *almost instantaneously* UNLESS
    you explicitly tell it to sleep().
     */
    private void onStart() {
        // Do your thing here!

        // You can delete this stuff, it's just for your reference
        // ===========
        // We can output helpful data through telemetry.
        // Or say hi to ourselves.
        // Telemetry is useful for debugging!
        String greeting = "Hello!";
        telemetry.addData("greeting1", "Hi!");
        telemetry.addData("greeting2", greeting);
        telemetry.update();

        // you can setPower on the motors
        // the power value should be from -1.0 to 1.0 (negative is backwards)
        lf.setPower(1.0);
        sleep(1000); /// 1000 ms = 1 second
        lf.setPower(0);


        // Each servo is a little different, so test out what number is a good position
        handServo.setPosition(0);
        sleep(1000);
        handServo.setPosition(1.0);
        // ===========

    }


    /*
    This stuff is called when we click STOP.
    With a real robot, we would want to make sure we explicitly stop
    all movement by setting motor powers to 0, but the simulator is
    nice and stops everything for you.

    Still! Try to make sure you safely "stop" the robot here.
     */
    private void onStop() {
        // Do your thing here!

    }


    // no touchy!
    // as you can see, I am just calling the functions above, but in order.
    // It's good practice to keep our code organized into different functions!!!
    @Override
    public void runOpMode() throws InterruptedException {
        onInit(); // we wrote this
        waitForStart(); // FTC wrote this
        onStart(); // you wrote this
        onStop(); // you wrote this
    }



}
