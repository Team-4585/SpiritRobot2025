package frc.robot;

public class SpiritRobotTeleopDecisionMaker {
  private SpiritRobotJoystick m_TheJoystick = new SpiritRobotJoystick();
  private WeaponsJoystick m_TheWeaponsJoystick = new WeaponsJoystick();

  
  private SpiritRobotChassis m_Chassis = new SpiritRobotChassis();
  private PneumaticsCompressor m_TheCompressor = new PneumaticsCompressor();
  private ShifterControl m_TheShifter = new ShifterControl();
  private ChassisEncoders m_ChassisEncoders = new ChassisEncoders();
  private Gyro m_TheGyro = new Gyro();
  //private Arm m_Arm = new Arm();
  private LED m_led = new LED();
  private CannonCompressor m_CannonCompressor = new CannonCompressor();
  private CannonMotor m_CannonMotor = new CannonMotor();


  SpiritRobotTeleopDecisionMaker(){

  }

  public void initialize(){
    System.out.println("Initializing...");
  }

  public void doDecisions(){

    if (m_TheJoystick.button6PressEvent()) {
      m_led.Shine();
    }

    if (m_TheJoystick.button3PressEvent()) {
      m_CannonCompressor.compress();
    }

    if (m_TheJoystick.button4PressEvent()) {
      m_CannonCompressor.stopCompress();
    }

    if(m_TheJoystick.button5Pushed()) {
      m_CannonMotor.open();
    }

    if(m_TheJoystick.button5ReleaseEvent()){
      m_CannonMotor.stop();
    }

    //if(m_TheJoystick.button11PressEvent()){
     // m_CannonMotor.stop();
    //}

    // System.out.println("-- F/B: " + m_TheJoystick.getForwardBackwardValue() + 
    //                    "   S/S: " + m_TheJoystick.getSideToSideValue() + 
    //                    "   Rot: " + m_TheJoystick.getTwistValue());

      m_Chassis.setTargForwardBack(m_TheJoystick.getForwardBackwardValue());
      m_Chassis.setTargRotation(m_TheJoystick.getTwistValue() / 4);

      if (m_TheJoystick.triggerReleaseEvent()){
        m_TheShifter.toggleGear();
        //m_TheCompressor.enableAfterShift();
      }

      //System.out.println(m_TheWeaponsJoystick.getForwardBackwardValue());
      //m_Arm.moveArm(-m_TheWeaponsJoystick.getForwardBackwardValue());
  

      //System.out.println(m_ChassisEncoders.GetLeftDegreesEncoderValue());
     // System.out.println(m_TheGyro.getHeading());
    }
  

  public void setChassis(SpiritRobotChassis TheChassis){
    m_Chassis = TheChassis;
  }


}
