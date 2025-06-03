import RPi.GPIO as GPIO
import time

IN1 = 17
IN2 = 27
ENA = 22  # Este es el pin que va a PWM

GPIO.setmode(GPIO.BCM)
GPIO.setup(IN1, GPIO.OUT)
GPIO.setup(IN2, GPIO.OUT)
GPIO.setup(ENA, GPIO.OUT)

# Configura PWM a 1000 Hz
pwm = GPIO.PWM(ENA, 1000)
pwm.start(0)  # Inicia en 0% velocidad

try:
    # Sentido de giro
    GPIO.output(IN1, GPIO.HIGH)
    GPIO.output(IN2, GPIO.LOW)

    # Velocidad progresiva
    for speed in range(0, 101, 10):  # De 0% a 100%
        pwm.ChangeDutyCycle(speed)
        print(f"Velocidad: {speed}%")
        time.sleep(0.5)

    # Mantén al 100% por 2 segundos
    time.sleep(2)

    # Baja velocidad gradualmente
    for speed in range(100, -1, -10):
        pwm.ChangeDutyCycle(speed)
        print(f"Velocidad: {speed}%")
        time.sleep(0.5)

finally:
    pwm.stop()
    GPIO.cleanup()
