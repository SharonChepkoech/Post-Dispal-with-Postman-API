package dev.chepkoech.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.chepkoech.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPosts()
//        displayPosts()
    }
    fun getPosts(){
        val getClient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = getClient.getPosts()

        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    val posts = response.body()
                    if (posts!=null){
                        displayPosts(posts)
                    }
//                    Toast.makeText(baseContext,"fetched ${posts!!.size}, posts",
//                    Toast.LENGTH_LONG).show()
//                    binding.rvMyPosts.layoutManager = LinearLayoutManager(baseContext)
//                    binding.rvMyPosts.adapter = PostActivityAdapter(baseContext,posts)
                }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun displayPosts(postList: List<Post>){
        binding.rvMyPosts.layoutManager = LinearLayoutManager(this)
        val postAdapterView = PostActivityAdapter(postList)
        binding.rvMyPosts.adapter = postAdapterView
    }


}