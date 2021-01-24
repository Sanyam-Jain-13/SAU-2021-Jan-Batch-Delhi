import React, {Component} from 'react';
import {View,Image} from 'react-native';


//Screen will be shown whenever the App will start;
export default class SplashScreen extends Component{

  constructor()
  {   
      super();
  }

  redirect = () =>
  {
    this.props.navigation.navigate('Home');
  }
  componentDidMount()
  { 
    setTimeout(() => {
      this.props.navigation.navigate('Home');
      }, 5000);
  }

  render()
  {
  
  return (
    <View>  
      <Image source={{ uri:'https://www.clipartkey.com/mpngs/m/124-1244844_a-stack-of-great-books-library-stack-of.png' }}  
      style ={{height:'100%',resizeMode:'cover'}} /> 
    </View> 
      );
  }
}