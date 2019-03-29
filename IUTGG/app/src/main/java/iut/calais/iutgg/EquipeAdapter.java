package iut.calais.iutgg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EquipeAdapter extends ArrayAdapter<Team> {
    public EquipeAdapter(Context context, ArrayList<Team> equipes) {
        super(context, 0, equipes);
    }
    //adapteur pour le fragment de l'équipe
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Team team = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_equipe, parent, false);
        }
        // Lookup view for data population
        TextView teamName = (TextView) convertView.findViewById(R.id.teamName);
        // Populate the data into the template view using the data object
        teamName.setText(team.getSlug());
        // Return the completed view to render on screen
        return convertView;
    }

}
