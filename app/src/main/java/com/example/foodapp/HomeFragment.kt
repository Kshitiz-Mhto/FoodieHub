package com.example.foodapp

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.navigation.findNavController
import com.example.foodapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val channelId = "com.example.foodapp.channel"
    private lateinit var notificationManager: NotificationManager
    private lateinit var alarmManager: AlarmManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        createNotificationChannel(channelId, "FoodChannel", "This is a test for food channel.")
        scheduleNotifications()

        binding.btnHome.setOnClickListener {
//            displayNotification()
            it.findNavController().navigate(
            R.id.action_homeFragment_to_dashboardFragment
            )
        }
        return binding.root
    }

    private fun scheduleNotifications() {
        val calendar = Calendar.getInstance()

        // Schedule notification for 10 am
        calendar.apply {
            set(Calendar.HOUR_OF_DAY, 10)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
        }
        scheduleNotification(calendar.timeInMillis, 1)

        // Schedule notification for 2 pm
        calendar.apply {
            set(Calendar.HOUR_OF_DAY, 14)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
        }
        scheduleNotification(calendar.timeInMillis, 2)

        // Schedule notification for 9 pm
        calendar.apply {
            set(Calendar.HOUR_OF_DAY, 21)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
        }
        scheduleNotification(calendar.timeInMillis, 3)
    }

    private fun scheduleNotification(timeInMillis: Long, notifyId: Int) {
        val intent = Intent(context!!, NotificationReceiver::class.java)
        intent.putExtra("notificationId", notifyId)
        val pendingIntent = PendingIntent.getBroadcast(
            context!!,
            notifyId,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        // Schedule the alarm
        alarmManager.setExact(
            AlarmManager.RTC_WAKEUP,
            timeInMillis,
            pendingIntent
        )
    }
    private fun displayNotification() {
        val notifyId = 44
        val notification = context?.let {
            NotificationCompat.Builder(it, channelId)
                .setContentTitle("Demo Title")
                .setContentText("This is a demo notification.")
                .setSmallIcon(R.drawable.hungry)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build()
        }

        notificationManager.notify(notifyId, notification)
    }

    private fun createNotificationChannel(id: String, name: String, description: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id, name, importance).apply {
                setDescription(description)
                enableLights(true)
                lightColor = Color.RED
                enableVibration(true)
                vibrationPattern = longArrayOf(100, 200, 300, 400, 500)
            }
            notificationManager.createNotificationChannel(channel)
        }
    }

    class NotificationReceiver : BroadcastReceiver() {
        private val channelId = "com.example.foodapp.channel"
        override fun onReceive(context: Context, intent: Intent) {
            val notifyId = intent.getIntExtra("notificationId", 0)
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val notification = NotificationCompat.Builder(context, channelId)
                .setContentTitle("Time to Eat!!")
                .setContentText("It's time to eat something.\uD83D\uDE0B")
                .setSmallIcon(R.drawable.hungry)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build()

            notificationManager.notify(notifyId, notification)
        }
    }

}