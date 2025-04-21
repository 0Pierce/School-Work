using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.ML.Data;

namespace Lab534
{
    internal class StudentData
    {
        [LoadColumn(0)]
        public float StudyTimePerGoalObj;

        [LoadColumn(1)]
        public float RepNumberOfUser;

        [LoadColumn(2)]
        public float StudyTimePerObj;

        [LoadColumn(3)]
        public float ExamPerfPerObj;
    }
    public class ClusterPrediction
    {
        [ColumnName("PredictedLabel")]
        public uint PredictedClusterId;

        [ColumnName("Score")]
        public float[]? Distances;
    }
}
