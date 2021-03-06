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

package io.github.erikjhordanrey.dagger2.category.model;

public class Category {

  private String mName;
  private int mIcon;
  private int mBackgroundColor;
  private int mPrimaryColor;

  Category(String mName, int mIcon, int mBackgroundColor, int mPrimaryColor) {
    this.mName = mName;
    this.mIcon = mIcon;
    this.mBackgroundColor = mBackgroundColor;
    this.mPrimaryColor = mPrimaryColor;
  }

  public String getName() {
    return mName;
  }

  public int getIcon() {
    return mIcon;
  }

  public int getBackgroundColor() {
    return mBackgroundColor;
  }

  public int getPrimaryColor() {
    return mPrimaryColor;
  }
}
