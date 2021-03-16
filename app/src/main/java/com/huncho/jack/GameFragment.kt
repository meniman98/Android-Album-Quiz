package com.huncho.jack

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.huncho.jack.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    data class Question(
        val text: String,
        val answers: List<String>,
        val image: Int
    )

    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "This legendary album was created by Quavo and Travis Scott in the winter of 2017. What is its name?",
            answers = listOf(
                "Huncho Jack, Jack Huncho",
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
            image = R.drawable.nav
        ),
        Question(
            text = "Future and Juice Wrld teamed up to release a hot duo album in 2018 autumn. What's the name?",
            answers = listOf(
                "Wrld on Drugs",
                "Legends Never Die",
                "Death Race for Love",
                "The Wizrd"
            ),
            image = R.drawable.wrld_on_drugs
        ),
        Question(
            text = "Justin Bieber released this album in the winter of 2015 and turned the population into beliebers. What's the name?",
            answers = listOf(
                "Purpose",
                "Changes",
                "Believe",
                "My World"
            ),
            image = R.drawable.purpose
        ),
        Question(
            text = "Lil Yachty released a sensational album in the spring of 2017. What's its name?",
            answers = listOf(
                "Teenage Emotions",
                "Nuthin' 2 Prove",
                "Lil Boat",
                "Lil Boat 2"
            ),
            image = R.drawable.teenage_emotions
        ),
        Question(
            text = "My favourite rapper PnB Rock released this album in beginning of 2017. What's its name?",
            answers = listOf(
                "Going Thru the Motions",
                "RnB 3",
                "TrapStar Turnt PopStar",
                "Money, Hoes and Flows"
            ),
            image = R.drawable.goin_thru_the_motions
        ),
        Question(
            text = "Drake dropped an album that brought tears to his fans on the winter of 2011. What's the name of this iconic album?",
            answers = listOf(
                "Take Care",
                "Views",
                "Nothing Was the Same",
                "Scorpion"

            ),
            image = R.drawable.take_care
        ),
        Question(
            text = "Drake and Future had the world dominated with this iconic album released in the summer of 2015. What's its name?",
            answers = listOf(
                "What a Time to Be Alive",
                "More Life",
                "Thank Me Later",
                "High Off Life"

            ),
            image = R.drawable.what_a_time_to_be_alive
        ),
        Question(
            text = "Travis Scott released a truly iconic album before he blew up in the summer of 2016. What's its name?",
            answers = listOf(
                "Birds in the Trap Sing McKnight",
                "Astroworld",
                "Rodeo",
                "Jackboys"
            ),
            image = R.drawable.birds_in_the_trap
        ),
        Question(
            text = "Future and Thugger released the hardest duo album in the autumn of 2017. What's its name?",
            answers = listOf(
                "Super Slimey",
                "Pluto x Baby Pluto",
                "Slime & B",
                "So Much Fun"

            ),
            image = R.drawable.super_slimey
        )


    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size + 1), 10)
    lateinit var binding: FragmentGameBinding
    lateinit var radioButtons: List<RadioButton>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game, container, false
        )

        randomiseQuestions()

        binding.model = this

        radioButtons = listOf(
            binding.rb1,
            binding.rb2,
            binding.rb3,
            binding.rb4
        )



        binding.btnSubmit.setOnClickListener { view: View ->
            val checkedId = binding.radioGroup.checkedRadioButtonId
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.rb2 -> answerIndex = 1
                    R.id.rb3 -> answerIndex = 2
                    R.id.rb4 -> answerIndex = 3
                }
                if (answers[answerIndex] == currentQuestion.answers[0]) {

                    questionIndex++
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                        for (radioButton in radioButtons) {
                            radioButton.setBackgroundColor(Color.TRANSPARENT)
                        }
                    } else {
                        // we won
                        view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToWonFragment())
                    }
                } else {
                    // we lost
                    when (checkedId) {
                        R.id.rb1 -> binding.rb1.setBackgroundColor(Color.RED)
                        R.id.rb2 -> binding.rb2.setBackgroundColor(Color.RED)
                        R.id.rb3 -> binding.rb3.setBackgroundColor(Color.RED)
                        R.id.rb4 -> binding.rb4.setBackgroundColor(Color.RED)
                    }

                }
            }
        }

        return binding.root
    }

    private fun randomiseQuestions() {
        questions.shuffle()
        questionIndex = 0

        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        binding.ivAlbumCover.setImageResource(currentQuestion.image)
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
        binding.radioGroup.clearCheck()
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.gameTitle, questionIndex + 1, numQuestions)
    }


}
