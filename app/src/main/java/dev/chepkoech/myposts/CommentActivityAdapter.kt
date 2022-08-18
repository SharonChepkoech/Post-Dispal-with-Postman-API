package dev.chepkoech.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.chepkoech.myposts.databinding.CommentsListItemBinding
import dev.chepkoech.myposts.databinding.PostItmsListBinding

class CommentActivityAdapter (var commentList:List<Comment>):RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding = CommentsListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return  CommentViewHolder(binding)
    }
//    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
//        var currentPost = postList.get(position)
//        val context = holder.itemView.context
//        with(holder.binding){
//            tvUserId.text = currentPost.userId.toString()
//            tvId.text = currentPost.id.toString()
//            tvTitle.text = currentPost.title
//            tvBody.text = currentPost.body
//            // I would have as well placed the val context here but I didn't because of neatness,
////            However, I placed it on top. also I use content so as to reduce using itemView all the time.
//            cvPosts.setOnClickListener {
//                val intent = Intent(context, CommentActivity::class.java)
//                intent.putExtra("POST_ID",currentPost.id)
//                context.startActivity(intent)

//    override fun getItemCount(): Int {
//        return postList.size
    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment = commentList.get(position)
        with(holder.binding){
            tvPostIdContent.text = currentComment.postId.toString()
            tvNameContent.text = currentComment.name
            tvCommentId.text = currentComment.id.toString()
            tvEmailContent.text = currentComment.email
            tvBodyContent.text = currentComment.body
        }
    }

    override fun getItemCount(): Int {
        return  commentList.size
    }


}


class CommentViewHolder( var binding: CommentsListItemBinding):RecyclerView.ViewHolder(binding.root)