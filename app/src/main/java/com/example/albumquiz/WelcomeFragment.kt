package com.example.albumquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.albumquiz.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    data class Question(
        val text: String,
        val answers: List<String>,
        val image: Int
    )

    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "This legendary album was created by Quavo and Travis Scott in the winter of 2017. What is its name?",
            answers = listOf(
                "Huncho Jack",
                "Culture",
                "Astroworld",
                "Quavo Huncho"
            ),
            image = R.drawable.hunchojack
        ),
        Question(
            text = "This banger of an album released in the spring of 2017 is named what?",
            answers = listOf(
                "NAV",
                "Reckless",
                "Good Intentions",
                "Perfect Timing"
            ),
            image = 2
        ),
        Question(
            text = "Future and Juice Wrld teamed up to release a hot duo album in 2018 autumn. What's the name?",
            answers = listOf(
                "Wrld on Drugs",
                "Legends Never Die",
                "Death Race for Love",
                "The Wizrd"
            ),
            image = 3
        ),
        Question(
            text = "Justin Bieber released this album in the winter of 2015 and turned the population into beliebers. What's the name?",
            answers = listOf(
                "Purpose",
                "Changes",
                "Believe",
                "My World"
            ),
            image = 4
        ),
        Question(
            text = "Lil Yachty released a sensational album in the spring of 2017. What's its name?",
            answers = listOf(
                "Teenage Emotions",
                "Nuthin' 2 Prove",
                "Lil Boat",
                "Lil Boat 2"
            ),
            image = 5
        ),
        Question(
            text = "My favourite rapper PnB Rock released this album in beginning of 2017. What's its name?",
            answers = listOf(
                "Going Thru the Motions",
                "RnB 3",
                "TrapStar Turnt PopStar",
                "Money, Hoes and Flows"
            ),
            image = 6
        ),
        Question(
            text = "Drake dropped an album that brought tears to his fans on the winter of 2011. What's the name of this iconic album?",
            answers = listOf(
                "Take Care",
                "Views",
                "Nothing Was the Same",
                "Scorpion"

            ),
            image = 7
        ),
        Question(
            text = "Drake and Future had the world dominated with this iconic album released in the summer of 2015. What's its name?",
            answers = listOf(
                "What a Time to Be Alive",
                "More Life",
                "Thank Me Later",
                "High Off Life"

            ),
            image = 8
        ),
        Question(
            text = "Travis Scott released a truly iconic album before he blew up in the summer of 2016. What's its name?",
            answers = listOf(
                "Birds in the Trap Sing McKnight",
                "Astroworld",
                "Rodeo",
                "Jackboys"
            ),
            image = 9
        ),
        Question(
            text = "Future and Thugger released the hardest duo album in the autumn of 2017. What's its name?",
            answers = listOf(
                "Super Slimey",
                "Pluto x Baby Pluto",
                "Slime & B",
                "So Much Fun"

            ),
            image = 10
        )


    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome, container, false
        )

        return binding.root


    }
}
