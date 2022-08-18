package dev.chepkoech.myposts

import android.provider.ContactsContract

data class Post(
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String
)
data class Comment(
    var postId: Int,
    var name: String,
    var id: Int,
    var email: String,
    var body: String
)
//fun main(){
//    var post = Post(12,1,"djdjk","Jjkd")
//    var comment = Comment(12,"23",23,"hfjfhj","nbmnm")
//}

//fun compareIds(post1: Post, post2: Post):Post{
//        if(post1.id> post2.id){
//            return post1
//        }
//        return post2
//    }
//fun <T> compareIds(item1: T, item2: T):T{
//  var output = (item1.toString() + item2.toString())
//    println(output)
//    return item1
//}
//fun stage(){
//    var post1 = Post(1,12,"abc","def")
//    var post2 = Post(1,12,"abwec","def")
//    compareIds(post1, post2)
//
//    var comment1 = Comment(1,"22sd",23,"jhf","bidy")
//    var comment2 = Comment(1,"22sd",23,"jhf","bidy")
//
//    compareIds(comment1, comment2)
//
//
//}

