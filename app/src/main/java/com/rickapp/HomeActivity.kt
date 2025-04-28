package com.rickapp

import android.os.Bundle
import android.transition.Fade
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.rickapp.adapter.Adapter
import com.rickapp.model.Character
import com.rickapp.databinding.ActivityHomeBinding
import com.rickapp.util.createFade

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setActivityAnimation()
        configureRecycler()
    }

    fun setActivityAnimation() {
        val fadeIn = createFade()
        window.enterTransition = fadeIn
    }

    fun configureRecycler() {

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.setHasFixedSize(true)

        var newArrayList: ArrayList<Character> = arrayListOf<Character>(
            Character("RICK1", R.drawable.rick_character),
            Character("RICK2", R.drawable.rick_character),
            Character("RICK3", R.drawable.rick_character),
            Character("RICK4", R.drawable.rick_character),
            Character("RICK5", R.drawable.rick_character),
            Character("RICK6", R.drawable.rick_character),
            Character("RICK7", R.drawable.rick_character),
            Character("RICK8", R.drawable.rick_character),
            Character("RICK9", R.drawable.rick_character),
            Character("RICK10", R.drawable.rick_character),
        )
        binding.recyclerView.adapter = Adapter(newArrayList)
    }

}