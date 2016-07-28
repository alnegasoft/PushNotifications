package mx.alnegasoft.mascotamd;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import mx.alnegasoft.mascotamd.adaptader.PageAdapter;
import mx.alnegasoft.mascotamd.fragment.MascotasFragment;
import mx.alnegasoft.mascotamd.fragment.PerfilFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

    }

    public void irMascotasVotadas(){
        Intent intent = new Intent(this , MascotasVotadas.class);
        startActivity(intent);
   }

    public void irFormulario(){
        Intent intent = new Intent(this , ComentariosActivity.class);
        startActivity(intent);
    }

    public void irAcercaDe(){
        Intent intent = new Intent(this , AcercaDeActivity.class);
        startActivity(intent);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
/*        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favoritas) {
            irMascotasVotadas();
            return true;
        }*/

        switch (item.getItemId()){
            case R.id.action_favoritas:
                irMascotasVotadas();
                break;
            case R.id.mContacto:
                irFormulario();
                break;
            case R.id.mAcercaDe:
                irAcercaDe();
                break;

        }




        return super.onOptionsItemSelected(item);
    }


    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new MascotasFragment());
        fragments.add((new PerfilFragment()));
        return  fragments;
    }


    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_perfil);
    }


}
