/*
 * Copyright (C) 2016 Erik Jhordan Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gdg.androidtitlan.dagger2_demo;

import android.app.Application;
import android.content.Context;
import gdg.androidtitlan.dagger2_demo.di.component.AppComponent;
import gdg.androidtitlan.dagger2_demo.di.component.DaggerAppComponent;
import gdg.androidtitlan.dagger2_demo.di.module.AppModule;

public class CategoryApplication extends Application {

  private AppComponent component;

  public static CategoryApplication get(Context context) {
    return (CategoryApplication) context.getApplicationContext();
  }

  @Override public void onCreate() {
    super.onCreate();
    setupGraph();
  }

  private void setupGraph() {
    component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    component.inject(this);
  }

  public AppComponent component() {
    return component;
  }
}