import pandas as pd
from  IPython.display import display


class MyDataFrame(pd.DataFrame):
    def __init__(self, *args, **kwargs):
        super(MyDataFrame,  self).__init__(*args, **kwargs)

    @property
    def _constructor(self):
        return MyDataFrame

    def my_custom_method(self):
        print('This actually works!')

    def display_left_align(self):
        'Shouldn`t using this function with the whole dataset, just use it for 10-20 rows'
        left_aligned_df = df.head().style.set_properties(**{'text-align': 'left'})
        left_aligned_df = left_aligned_df.set_table_styles(
            [dict(selector='th', props=[('text-align', 'left')])])
        display(left_aligned_df)



df = MyDataFrame()
df.display_left_align()





