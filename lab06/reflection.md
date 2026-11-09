# Reflection Questions 

1. Why must getDefaultSensor() be treated as potentially returning null? 

getDefaultSensor() returns null if the device doesn't have that sensor at all. Not every phone has an ambient temperature sensor and some don't have a gyroscope either. So the reference needs to stay nullable, otherwise the app would crash with a NullPointerException. Instead we check for null and show "not available" to the user. 

 

2. Why should sensor listeners be unregistered when the activity is paused? 

If we leave the listener registered, it keeps getting sensor events even when the activity is in the background. That wastes battery on updates nobody can see. So we call unregisterListener() in onPause(), and then register again in onResume() when the activity comes back to the foreground. 

 

3. What is the difference between gyroscope angular velocity and device orientation? 

The gyroscope tells you how fast the device is rotating at that moment. Orientation is where the device is in space, like which direction it's facing. If you hold the phone still at an angle, the orientation is non-zero but the angular velocity is basically zero. When you start turning it, you get angular velocity, and when you stop, the velocity goes back to near zero even though the orientation has changed. 

 

4. What units are used for the gyroscope values in this lab? 

Radians per second (rad/s), for each of the X, Y and Z axes. 

 

5. Why is battery temperature not a valid replacement for TYPE_AMBIENT_TEMPERATURE? 

Battery temperature is the temperature of the battery, which gets warmed up by charging and by the processor. It's not the temperature of the air around the phone, so it doesn't actually measure what TYPE_AMBIENT_TEMPERATURE measures. If the ambient sensor is missing, we should just report it as unavailable instead of using battery temp as a substitute. 

 

6. How does mutableStateOf allow a SensorEvent callback to update the Compose UI? 

temperature, gyroX, gyroY and gyroZ are all Compose state. SensorScreen reads them during composition, so Compose knows to track those reads. When onSensorChanged() fires, it writes the new event.values into that state. That write invalidates the composition and Compose recomposes the screen with the new values. The sensor callback never touches the UI widgets directly, it just updates the state. 

