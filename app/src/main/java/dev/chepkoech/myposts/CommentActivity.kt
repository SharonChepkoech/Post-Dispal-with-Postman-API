package dev.chepkoech.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.chepkoech.myposts.databinding.ActivityCommentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentBinding
    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPost()
        getComments()
    }
    fun obtainPostId(){
        postId = intent.extras?.getInt("POST_ID", 0)?: 0
    }
    fun fetchPost(){
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostById(postId)

        request.enqueue(object: Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                var post = response.body()
                if (post != null){
                    binding.tvPostTittle.text = post.title
                    binding.tvTextBody.text = post.body
                }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) {
            }
        })
    }
    fun getComments(){
        val getClient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = getClient.getComments()

        request.enqueue(object : Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if (response.isSuccessful){
                    val comments = response.body()
                    if (comments!=null){
                        displayComments(comments)
                    }
                }
            }
            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
    fun displayComments(commentList: List<Comment>){
        binding.rvComments.layoutManager = LinearLayoutManager(this)
        val commentAdapter = CommentActivityAdapter(commentList)
        binding.rvComments.adapter = commentAdapter
    }
}