package br.com.thiengo.blogpage;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;

public class BlogPageActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsing = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsing.setTitle("Como Também Monetizar Usuários Inativos de Seu Aplicativo Android");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Conteúdo compartilhado", Snackbar.LENGTH_LONG)
                        .setAction("Compartilhar", null).show();
            }
        });

        FlexboxLayout fl = generateFlexbox();
        fl.addView( generateTag( "android" ) );
        fl.addView( generateTag( "app mobile" ) );
        fl.addView( generateTag( "monetização" ) );
        fl.addView( generateTag( "calldorado" ) );
        fl.addView( generateTag( "identificador de chamadas" ) );
        fl.addView( generateTag( "filmes" ) );
        fl.addView( generateTag( "cinema" ) );

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl_container);
        rl.addView( fl );
    }


    public void tagClick( View view ){
        TextView tv = (TextView) view;

        Toast.makeText(this, "Tag: " + tv.getText(), Toast.LENGTH_SHORT).show();
    }

    public static int getDpToPx(int pixels ){
        return (int) (pixels * Resources.getSystem().getDisplayMetrics().density);
    }


    private FlexboxLayout generateFlexbox(){
        FlexboxLayout fl = new FlexboxLayout(this);

        fl.setFlexWrap(FlexboxLayout.FLEX_WRAP_WRAP);
        fl.setFlexDirection(FlexboxLayout.FLEX_DIRECTION_ROW);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT);

        lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_START);
        lp.addRule(RelativeLayout.BELOW, R.id.tv_tags_title);
        fl.setLayoutParams( lp );

        return fl;
    }


    private TextView generateTag( String tag ){
        TextView tv = new TextView(this);
        tv.setText( tag );
        tv.setBackgroundResource( R.drawable.borda_tag );
        tv.setPadding(
            getDpToPx( 12 ),
            getDpToPx( 8 ),
            getDpToPx( 12 ),
            getDpToPx( 8 ) );

        tv.setOnClickListener(this);
        tv.setGravity( Gravity.CENTER );
        tv.setTextSize( TypedValue.COMPLEX_UNIT_SP, 18 );

        FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(
            FlexboxLayout.LayoutParams.WRAP_CONTENT,
            FlexboxLayout.LayoutParams.WRAP_CONTENT );
        lp.flexGrow = 1f;
        lp.setMargins(
            getDpToPx( 2 ),
            getDpToPx( 4 ),
            getDpToPx( 2 ),
            0 );

        tv.setLayoutParams( lp );

        return tv;
    }

    @Override
    public void onClick(View view) {
        tagClick( view );
    }
}
