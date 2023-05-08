import FirstComponent from './FirstComponent'
import { FifthComponent } from './FirstComponent' // default export아닐때는 {}써서 import해야한다.
import SecondComponent from './SecondComponent';
import ThirdComponent from './ThirdComponent';
import FourthComponent from './FourthComponent';
import LearningJavaScript from './LearningJavaScript';

export default function LearningComponent() {
    return (
      <div className="LearningComponent">
        <FirstComponent />
        <FifthComponent />
        <SecondComponent />
        <ThirdComponent />
        <FourthComponent />
        <LearningJavaScript/>
      </div>
    );
  }