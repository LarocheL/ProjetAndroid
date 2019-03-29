package iut.calais.iutgg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
//adapteur pour le Match fragment
public class MatchAdapter extends ArrayAdapter<Match> {
    public MatchAdapter(Context context, ArrayList<Match> matchs) {
        super(context, 0, matchs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Match match = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_match, parent, false);
        }
        // Lookup view for data population
        TextView leagueName = (TextView) convertView.findViewById(R.id.leagueName);
        TextView leagueStart = (TextView) convertView.findViewById(R.id.leagueStart);
        TextView leagueTeam = (TextView) convertView.findViewById(R.id.leagueTeam);
        // Populate the data into the template view using the data object
        leagueName.setText(match.getTournament().name);
        leagueStart.setText(match.getTournament().begin_at.toString());

        if(!match.getOpponents().isEmpty()) {
            leagueTeam.setText(match.getOpponents().iterator().next().getOpponent().getSlug());
        }
        // Return the completed view to render on screen
        return convertView;
    }

}
