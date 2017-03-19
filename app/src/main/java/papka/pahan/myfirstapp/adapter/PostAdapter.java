package papka.pahan.myfirstapp.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import papka.pahan.myfirstapp.R;
import papka.pahan.myfirstapp.model.Post;

/**
 * Created by admin on 14.03.2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PersonViewHolder> {

    private List<Post> postsList;

    public PostAdapter(List<Post> postsList) {
        this.postsList = postsList;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_view, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostAdapter.PersonViewHolder holder, int position) {
        holder.bind(postsList.get(position));
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }


    public class PersonViewHolder extends RecyclerView.ViewHolder {

        TextView textViewId;
        TextView textViewTitle;
        TextView textViewBody;
        CardView cardView;

        public PersonViewHolder(View itemView) {
            super(itemView);
            textViewId = (TextView) itemView.findViewById(R.id.id_user);
            textViewTitle = (TextView) itemView.findViewById(R.id.user_title);
            textViewBody = (TextView) itemView.findViewById(R.id.body_user);
            cardView = (CardView) itemView.findViewById(R.id.cv);
        }

        public void bind(Post post) {
            textViewBody.setText(post.getBody());
            textViewTitle.setText(post.getTitle());
            textViewId.setText(String.valueOf(post.getId()));
        }
    }
}
