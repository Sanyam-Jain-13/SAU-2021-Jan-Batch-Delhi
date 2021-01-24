import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';

import HomeScreen from './Components/HomeScreen';
import ProductDetails from './Components/ProductDetails';
import SplashScreen from './Components/SplashScreen';

const Stack = createStackNavigator();

const MyStack = () => {
  return (
    <NavigationContainer>
      
      <Stack.Navigator initialRouteName="Splash">

        <Stack.Screen
          name="Splash"
          component={SplashScreen}
          options={{ title: 'Welcome to my Library', headerLeft : null }}
        />
        
        <Stack.Screen
          name="Home"
          component={HomeScreen}
          options={{ title: 'Library', headerLeft : null  }}
        />
        
        <Stack.Screen
        name="Details" 
        component={ProductDetails}
        options={{ title: 'Product Details' }}
        />

      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default MyStack;